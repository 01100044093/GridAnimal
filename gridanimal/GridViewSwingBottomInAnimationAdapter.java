
package zn.gridanimal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * An implementation of the AnimationAdapter class which applies a
 * swing-in-from-bottom-animation to views.
 */
public class GridViewSwingBottomInAnimationAdapter extends GridViewSingleAnimationAdapter {

	private final long mAnimationDelayMillis;
	private final long mAnimationDurationMillis;

	public GridViewSwingBottomInAnimationAdapter(BaseAdapter baseAdapter) {
		this(baseAdapter, DEFAULTANIMATIONDELAYMILLIS, DEFAULTANIMATIONDURATIONMILLIS);
	}

	public GridViewSwingBottomInAnimationAdapter(BaseAdapter baseAdapter, long animationDelayMillis) {
		this(baseAdapter, animationDelayMillis, DEFAULTANIMATIONDURATIONMILLIS);
	}

	public GridViewSwingBottomInAnimationAdapter(BaseAdapter baseAdapter, long animationDelayMillis, long animationDurationMillis) {
		super(baseAdapter);
		mAnimationDelayMillis = animationDelayMillis;
		mAnimationDurationMillis = animationDurationMillis;
	}

	@Override
	protected long getAnimationDelayMillis() {
		return mAnimationDelayMillis;
	}

	@Override
	protected long getAnimationDurationMillis() {
		return mAnimationDurationMillis;
	}

	@Override
	protected Animator getAnimator(ViewGroup parent, View view) {
		return ObjectAnimator.ofFloat(view, "translationY", 500, 0);
	}

}
