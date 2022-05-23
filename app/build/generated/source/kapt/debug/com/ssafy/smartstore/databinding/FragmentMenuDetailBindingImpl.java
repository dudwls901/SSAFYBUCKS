package com.ssafy.smartstore.databinding;
import com.ssafy.smartstore.R;
import com.ssafy.smartstore.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMenuDetailBindingImpl extends FragmentMenuDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_item, 5);
        sViewsWithIds.put(R.id.container_info, 6);
        sViewsWithIds.put(R.id.tv_header_price, 7);
        sViewsWithIds.put(R.id.tv_header_quantity, 8);
        sViewsWithIds.put(R.id.iv_minus, 9);
        sViewsWithIds.put(R.id.tv_quantity, 10);
        sViewsWithIds.put(R.id.iv_plus, 11);
        sViewsWithIds.put(R.id.container_rating, 12);
        sViewsWithIds.put(R.id.tv_header_rating, 13);
        sViewsWithIds.put(R.id.container_comment, 14);
        sViewsWithIds.put(R.id.tl_comment, 15);
        sViewsWithIds.put(R.id.et_comment, 16);
        sViewsWithIds.put(R.id.btn_register_comment, 17);
        sViewsWithIds.put(R.id.rv_comment, 18);
        sViewsWithIds.put(R.id.btn_put, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMenuDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentMenuDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.appcompat.widget.AppCompatButton) bindings[19]
            , (androidx.appcompat.widget.AppCompatButton) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputEditText) bindings[16]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[11]
            , (androidx.appcompat.widget.AppCompatRatingBar) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (com.google.android.material.textfield.TextInputLayout) bindings[15]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[13]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[10]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.ratingBar.setTag(null);
        this.tvName.setTag(null);
        this.tvPrice.setTag(null);
        this.tvRating.setTag(null);
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
        if (BR.productVM == variableId) {
            setProductVM((com.ssafy.smartstore.viewmodel.ProductViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProductVM(@Nullable com.ssafy.smartstore.viewmodel.ProductViewModel ProductVM) {
        this.mProductVM = ProductVM;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.productVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeProductVMProduct((androidx.lifecycle.LiveData<com.ssafy.smartstore.data.local.dto.Product>) object, fieldId);
            case 1 :
                return onChangeProductVMRatingAvg((androidx.lifecycle.LiveData<java.lang.Float>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeProductVMProduct(androidx.lifecycle.LiveData<com.ssafy.smartstore.data.local.dto.Product> ProductVMProduct, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeProductVMRatingAvg(androidx.lifecycle.LiveData<java.lang.Float> ProductVMRatingAvg, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        androidx.lifecycle.LiveData<com.ssafy.smartstore.data.local.dto.Product> productVMProduct = null;
        float androidxDatabindingViewDataBindingSafeUnboxProductVMRatingAvgGetValue = 0f;
        androidx.lifecycle.LiveData<java.lang.Float> productVMRatingAvg = null;
        java.lang.String productVMRatingAvgJavaLangString = null;
        com.ssafy.smartstore.viewmodel.ProductViewModel productVM = mProductVM;
        java.lang.Float productVMRatingAvgGetValue = null;
        java.lang.String productVMProductName = null;
        java.lang.String productVMRatingAvgIsNaNJavaLangStringProductVMRatingAvgJavaLangString = null;
        int productVMProductPrice = 0;
        java.lang.String productVMProductPriceJavaLangString = null;
        boolean productVMRatingAvgIsNaN = false;
        com.ssafy.smartstore.data.local.dto.Product productVMProductGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (productVM != null) {
                        // read productVM.product
                        productVMProduct = productVM.getProduct();
                    }
                    updateLiveDataRegistration(0, productVMProduct);


                    if (productVMProduct != null) {
                        // read productVM.product.getValue()
                        productVMProductGetValue = productVMProduct.getValue();
                    }


                    if (productVMProductGetValue != null) {
                        // read productVM.product.getValue().name
                        productVMProductName = productVMProductGetValue.getName();
                        // read productVM.product.getValue().price
                        productVMProductPrice = productVMProductGetValue.getPrice();
                    }


                    // read (productVM.product.getValue().price) + (" 원")
                    productVMProductPriceJavaLangString = (productVMProductPrice) + (" 원");
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (productVM != null) {
                        // read productVM.ratingAvg
                        productVMRatingAvg = productVM.getRatingAvg();
                    }
                    updateLiveDataRegistration(1, productVMRatingAvg);


                    if (productVMRatingAvg != null) {
                        // read productVM.ratingAvg.getValue()
                        productVMRatingAvgGetValue = productVMRatingAvg.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(productVM.ratingAvg.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxProductVMRatingAvgGetValue = androidx.databinding.ViewDataBinding.safeUnbox(productVMRatingAvgGetValue);
                    if (productVMRatingAvgGetValue != null) {
                        // read productVM.ratingAvg.getValue().isNaN()
                        productVMRatingAvgIsNaN = productVMRatingAvgGetValue.isNaN();
                    }
                if((dirtyFlags & 0xeL) != 0) {
                    if(productVMRatingAvgIsNaN) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                // read (productVM.ratingAvg.getValue()) + ("점")
                productVMRatingAvgJavaLangString = (productVMRatingAvgGetValue) + ("점");
        }

        if ((dirtyFlags & 0xeL) != 0) {

                // read productVM.ratingAvg.getValue().isNaN() ? "없음" : (productVM.ratingAvg.getValue()) + ("점")
                productVMRatingAvgIsNaNJavaLangStringProductVMRatingAvgJavaLangString = ((productVMRatingAvgIsNaN) ? ("없음") : (productVMRatingAvgJavaLangString));
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar, androidxDatabindingViewDataBindingSafeUnboxProductVMRatingAvgGetValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvRating, productVMRatingAvgIsNaNJavaLangStringProductVMRatingAvgJavaLangString);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, productVMProductName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPrice, productVMProductPriceJavaLangString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): productVM.product
        flag 1 (0x2L): productVM.ratingAvg
        flag 2 (0x3L): productVM
        flag 3 (0x4L): null
        flag 4 (0x5L): productVM.ratingAvg.getValue().isNaN() ? "없음" : (productVM.ratingAvg.getValue()) + ("점")
        flag 5 (0x6L): productVM.ratingAvg.getValue().isNaN() ? "없음" : (productVM.ratingAvg.getValue()) + ("점")
    flag mapping end*/
    //end
}