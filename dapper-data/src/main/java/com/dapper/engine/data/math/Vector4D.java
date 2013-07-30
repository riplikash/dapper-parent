package com.dapper.engine.data.math;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vector4D {
    Double A, B, C, D;
    Vector4D()
    {
       A = B = C = D = 0.0;
    }
    Vector4D(double a, double b, double c, double d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public Vector4D sum(Vector4D theta) {
        return new Vector4D(A + theta.A, B + theta.B, C + theta.C, 1);

    }

    public void translate(Vector4D theta) {
        A += theta.A;
        B += theta.B;
        C += theta.C;
    }

    public Vector4D product(Vector4D theta) {
        return new Vector4D(A * theta.A, B * theta.B, C * theta.C, 1);
    }
}
