package com.ssafy.smartstore.databinding;
import com.ssafy.smartstore.R;
import com.ssafy.smartstore.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentShoppingListBindingImpl extends FragmentShoppingListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_cart, 4);
        sViewsWithIds.put(R.id.btn_take_in, 5);
        sViewsWithIds.put(R.id.btn_take_out, 6);
        sViewsWithIds.put(R.id.rv_order_list, 7);
        sViewsWithIds.put(R.id.btn_order, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentShoppingListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentShoppingListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (androidx.appcompat.widget.AppCompatButton) bindings[8]
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            , (android.widget.ProgressBar) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.loadingBar.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvOrderCount.setTag(null);
        this.tvPriceSum.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.orderVM == variableId) {
            setOrderVM((com.ssafy.smartstore.viewmodel.OrderViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOrderVM(@Nullable com.ssafy.smartstore.viewmodel.OrderViewModel OrderVM) {
        this.mOrderVM = OrderVM;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.orderVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeOrderVMOrderCount((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeOrderVMPriceSum((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeOrderVMLoading((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeOrderVMOrderCount(androidx.lifecycle.LiveData<java.lang.String> OrderVMOrderCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeOrderVMPriceSum(androidx.lifecycle.LiveData<java.lang.String> OrderVMPriceSum, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeOrderVMLoading(androidx.lifecycle.LiveData<java.lang.Boolean> OrderVMLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        int orderVMLoadingViewVISIBLEViewGONE = 0;
        java.lang.String orderVMOrderCountGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> orderVMOrderCount = null;
        java.lang.String orderVMPriceSumGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxOrderVMLoadingGetValue = false;
        com.ssafy.smartstore.viewmodel.OrderViewModel orderVM = mOrderVM;
        androidx.lifecycle.LiveData<java.lang.String> orderVMPriceSum = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> orderVMLoading = null;
        java.lang.Boolean orderVMLoadingGetValue = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (orderVM != null) {
                        // read orderVM.orderCount
                        orderVMOrderCount = orderVM.getOrderCount();
                    }
                    updateLiveDataRegistration(0, orderVMOrderCount);


                    if (orderVMOrderCount != null) {
                        // read orderVM.orderCount.getValue()
                        orderVMOrderCountGetValue = orderVMOrderCount.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (orderVM != null) {
                        // read orderVM.priceSum
                        orderVMPriceSum = orderVM.getPriceSum();
                    }
                    updateLiveDataRegistration(1, orderVMPriceSum);


                    if (orderVMPriceSum != null) {
                        // read orderVM.priceSum.getValue()
                        orderVMPriceSumGetValue = orderVMPriceSum.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (orderVM != null) {
                        // read orderVM.loading
                        orderVMLoading = orderVM.getLoading();
                    }
                    updateLiveDataRegistration(2, orderVMLoading);


                    if (orderVMLoading != null) {
                        // read orderVM.loading.getValue()
                        orderVMLoadingGetValue = orderVMLoading.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(orderVM.loading.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxOrderVMLoadingGetValue = androidx.databinding.ViewDataBinding.safeUnbox(orderVMLoadingGetValue);
                if((dirtyFlags & 0x1cL) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxOrderVMLoadingGetValue) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(orderVM.loading.getValue()) ? View.VISIBLE : View.GONE
                    orderVMLoadingViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxOrderVMLoadingGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.loadingBar.setVisibility(orderVMLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvOrderCount, orderVMOrderCountGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPriceSum, orderVMPriceSumGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): orderVM.orderCount
        flag 1 (0x2L): orderVM.priceSum
        flag 2 (0x3L): orderVM.loading
        flag 3 (0x4L): orderVM
        flag 4 (0x5L): null
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(orderVM.loading.getValue()) ? View.VISIBLE : View.GONE
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(orderVM.loading.getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}