package com.ssafy.smartstore.databinding;
import com.ssafy.smartstore.R;
import com.ssafy.smartstore.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.container_profile, 2);
        sViewsWithIds.put(R.id.tv_header_name, 3);
        sViewsWithIds.put(R.id.tv_hello, 4);
        sViewsWithIds.put(R.id.tv_header_notice, 5);
        sViewsWithIds.put(R.id.container_notice, 6);
        sViewsWithIds.put(R.id.rv_noti, 7);
        sViewsWithIds.put(R.id.tv_header_recent_order, 8);
        sViewsWithIds.put(R.id.rv_recent_order, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.ProgressBar) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            );
        this.loadingBar.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.homeVM == variableId) {
            setHomeVM((com.ssafy.smartstore.viewmodel.HomeViewModel) variable);
        }
        else if (BR.orderVM == variableId) {
            setOrderVM((com.ssafy.smartstore.viewmodel.OrderViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHomeVM(@Nullable com.ssafy.smartstore.viewmodel.HomeViewModel HomeVM) {
        this.mHomeVM = HomeVM;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.homeVM);
        super.requestRebind();
    }
    public void setOrderVM(@Nullable com.ssafy.smartstore.viewmodel.OrderViewModel OrderVM) {
        this.mOrderVM = OrderVM;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeHomeVMLoading((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeHomeVMLoading(androidx.lifecycle.LiveData<java.lang.Boolean> HomeVMLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        com.ssafy.smartstore.viewmodel.HomeViewModel homeVM = mHomeVM;
        int homeVMLoadingViewVISIBLEViewGONE = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxHomeVMLoadingGetValue = false;
        androidx.lifecycle.LiveData<java.lang.Boolean> homeVMLoading = null;
        java.lang.Boolean homeVMLoadingGetValue = null;

        if ((dirtyFlags & 0xbL) != 0) {



                if (homeVM != null) {
                    // read homeVM.loading
                    homeVMLoading = homeVM.getLoading();
                }
                updateLiveDataRegistration(0, homeVMLoading);


                if (homeVMLoading != null) {
                    // read homeVM.loading.getValue()
                    homeVMLoadingGetValue = homeVMLoading.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(homeVM.loading.getValue())
                androidxDatabindingViewDataBindingSafeUnboxHomeVMLoadingGetValue = androidx.databinding.ViewDataBinding.safeUnbox(homeVMLoadingGetValue);
            if((dirtyFlags & 0xbL) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxHomeVMLoadingGetValue) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(homeVM.loading.getValue()) ? View.VISIBLE : View.GONE
                homeVMLoadingViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxHomeVMLoadingGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            this.loadingBar.setVisibility(homeVMLoadingViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): homeVM.loading
        flag 1 (0x2L): homeVM
        flag 2 (0x3L): orderVM
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(homeVM.loading.getValue()) ? View.VISIBLE : View.GONE
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(homeVM.loading.getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}