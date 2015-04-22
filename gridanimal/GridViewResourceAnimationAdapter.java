
package zn.gridanimal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorInflater;

/**
 * An implementation of AnimationAdapter which bases the animations on
 * resources.
 */
public abstract class GridViewResourceAnimationAdapter<T> extends GridViewAnimationAdapter {

	private Context mContext;

	public GridViewResourceAnimationAdapter(BaseAdapter baseAdapter, Context context) {
		super(baseAdapter);
		mContext = context;
	}

	@Override
	public Animator[] getAnimators(ViewGroup parent, View view) {
		return new Animator[] { AnimatorInflater.loadAnimator(mContext, getAnimationResourceId()) };
	}

	/**
	 * Get the resource id of the animation to apply to the views.
	 */
	protected abstract int getAnimationResourceId();

}
