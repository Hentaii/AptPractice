package com.example;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class BindViewField {
    private VariableElement mVariableElement;
    private int mResId;

    public BindViewField(Element element) throws IllegalArgumentException{
        if (element.getKind() != ElementKind.FIELD) {
            throw new IllegalArgumentException(
                    String.format(
                            "value() in %s for field %s is not valid !",
                            BindView.class.getSimpleName(),
                            mVariableElement.getSimpleName()));
        }
        mVariableElement = (VariableElement) element;

        BindView bindView = mVariableElement.getAnnotation(BindView.class);
        mResId = bindView.value();
        if (mResId < 0) {
            throw new IllegalArgumentException(
                    String.format("value() in %s for field %s is not valid !", BindView.class.getSimpleName(),
                            mVariableElement.getSimpleName()));
        }
    }

    public Name getFieldName() {
        return mVariableElement.getSimpleName();
    }

    public int getResId() {
        return mResId;
    }

    public TypeMirror getFieldType() {
        return mVariableElement.asType();
    }


}
