
package zn.gridanimal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.animation.Animator;

/**
 * An implementation of AnimationAdapter which applies a single Animator to
 * views.
 */
public abstract class GridViewSingleAnimationAdapter extends GridViewAnimationAdapter {

	public GridViewSingleAnimationAdapter(BaseAdapter baseAdapter) {
		super(baseAdapter);
	}

	@Override
	public Animator[] getAnimators(ViewGroup parent, View view) {
		Animator animator = getAnimator(parent, view);
		return new Animator[] { animator };
	}

	/**
	 * Get the Animator to apply to the view.
	 * 
	 * @param parent
	 *            the ViewGroup which is the parent of the view.
	 * @param view
	 *            the view that will be animated, as retrieved by getView().
	 */
	protected abstract Animator getAnimator(ViewGroup parent, View view);

}
