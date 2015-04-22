
package zn.gridanimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

/**
 * A BaseAdapterDecorator class that provides animations to the removal of items
 * in the given BaseAdapter.
 */
public class GridViewAnimateDismissAdapter<T> extends BaseAdapterGridViewDecorator {

	private GridViewOnDismissCallback mCallback;

	/**
	 * Create a new AnimateDismissAdapter based on the given ArrayAdapter.
	 * 
	 * @param callback
	 *            The callback to trigger when the user has indicated that she
	 *            would like to dismiss one or more list items.
	 */
	public GridViewAnimateDismissAdapter(BaseAdapter baseAdapter, GridViewOnDismissCallback callback) {
		super(baseAdapter);
		mCallback = callback;
	}

	public void animateDismiss(int index) {
		animateDismiss(Arrays.asList(index));
	}

	public void animateDismiss(Collection<Integer> positions) {
		final List<Integer> positionsCopy = new ArrayList<Integer>(positions);
		Assert.assertNotNull("Call setListView() on this AnimateDismissAdapter before calling setAdapter()!", getGridView());

		List<View> views = getVisibleViewsForPositions(positionsCopy);

		if (!views.isEmpty()) {
			List<Animator> animators = new ArrayList<Animator>();
			for (final View view : views) {
				animators.add(createAnimatorForView(view));
			}

			AnimatorSet animatorSet = new AnimatorSet();

			Animator[] animatorsArray = new Animator[animators.size()];
			for (int i = 0; i < animatorsArray.length; i++) {
				animatorsArray[i] = animators.get(i);
			}

			animatorSet.playTogether(animatorsArray);
			animatorSet.addListener(new AnimatorListener() {

				@Override
				public void onAnimationStart(Animator arg0) {
				}

				@Override
				public void onAnimationRepeat(Animator arg0) {
				}

				@Override
				public void onAnimationEnd(Animator arg0) {
					invokeCallback(positionsCopy);
				}

				@Override
				public void onAnimationCancel(Animator arg0) {
				}
			});
			animatorSet.start();
		} else {
			invokeCallback(positionsCopy);
		}
	}

	private void invokeCallback(Collection<Integer> positions) {
		ArrayList<Integer> positionsList = new ArrayList<Integer>(positions);
		Collections.sort(positionsList);
		int[] dismissPositions = new int[positionsList.size()];
		for (int i = 0; i < positionsList.size(); i++) {
			dismissPositions[i] = positionsList.get(positionsList.size() - 1 - i);
		}
		mCallback.onDismiss(getGridView(), dismissPositions);
	}

	private List<View> getVisibleViewsForPositions(Collection<Integer> positions) {
		List<View> views = new ArrayList<View>();
		for (int i = 0; i < getGridView().getChildCount(); i++) {
			View child = getGridView().getChildAt(i);
			if (positions.contains(getGridView().getPositionForView(child))) {
				views.add(child);
			}
		}
		return views;
	}

	private Animator createAnimatorForView(final View view) {
		final ViewGroup.LayoutParams lp = view.getLayoutParams();
		final int originalHeight = view.getHeight();

		ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 0);
		animator.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator arg0) {
			}

			@Override
			public void onAnimationRepeat(Animator arg0) {
			}

			@Override
			public void onAnimationEnd(Animator arg0) {
				lp.height = 0;
				view.setLayoutParams(lp);
			}

			@Override
			public void onAnimationCancel(Animator arg0) {
			}
		});

		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator valueAnimator) {
				lp.height = (Integer) valueAnimator.getAnimatedValue();
				view.setLayoutParams(lp);
			}
		});

		return animator;
	}
}
