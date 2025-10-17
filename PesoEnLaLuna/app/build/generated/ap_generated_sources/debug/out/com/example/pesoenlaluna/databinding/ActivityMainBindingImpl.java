package com.example.pesoenlaluna.databinding;
import com.example.pesoenlaluna.R;
import com.example.pesoenlaluna.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding implements com.example.pesoenlaluna.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_moon, 2);
        sViewsWithIds.put(R.id.edit_text_weight, 3);
        sViewsWithIds.put(R.id.text_view_result, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.buttonCalculate.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.pesoenlaluna.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mainActivity == variableId) {
            setMainActivity((com.example.pesoenlaluna.MainActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainActivity(@Nullable com.example.pesoenlaluna.MainActivity MainActivity) {
        this.mMainActivity = MainActivity;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mainActivity);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.pesoenlaluna.MainActivity mainActivity = mMainActivity;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.buttonCalculate.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // mainActivity
        com.example.pesoenlaluna.MainActivity mainActivity = mMainActivity;
        // mainActivity != null
        boolean mainActivityJavaLangObjectNull = false;



        mainActivityJavaLangObjectNull = (mainActivity) != (null);
        if (mainActivityJavaLangObjectNull) {


            mainActivity.calculateMoonWeight();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mainActivity
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}