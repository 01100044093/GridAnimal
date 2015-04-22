
package zn.gridanimal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class GridViewScaleInAnimationAdapter extends GridViewAnimationAdapter {

	private static final float DEFAULTSCALEFROM = 0.8f;

	private float mScaleFrom;
	private long mAnimationDelayMillis;
	private long mAnimationDurationMillis;

	public GridViewScaleInAnimationAdapter(BaseAdapter baseAdapter) {
		this(baseAdapter, DEFAULTSCALEFROM);
	}

	public GridViewScaleInAnimationAdapter(BaseAdapter baseAdapter, float scaleFrom) {
		this(baseAdapter, scaleFrom, DEFAULTANIMATIONDELAYMILLIS, DEFAULTANIMATIONDURATIONMILLIS);
	}

	public GridViewScaleInAnimationAdapter(BaseAdapter baseAdapter, float scaleFrom, long animationDelayMillis, long animationDurationMillis) {
		super(baseAdapter);
		mScaleFrom = scaleFrom;
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
	public Animator[] getAnimators(ViewGroup parent, View view) {
		ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", mScaleFrom, 1f);
		ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", mScaleFrom, 1f);
		return new ObjectAnimator[] { scaleX, scaleY };
	}

}
