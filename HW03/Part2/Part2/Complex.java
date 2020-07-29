package com.emire;

public class Complex
{
    private double real;

    private double imaginary;

    public Complex()
    {
        real = 0.0;
        imaginary = 0.0;
    }

    public Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void set(Complex z)
    {
        this.real = z.real;
        this.imaginary = z.imaginary;
    }

    public double getIm()
    {
        return this.imaginary;
    }

    public double getReal()
    {
        return this.real;
    }
    public void add(Complex z)
    {
        set(add(this,z));
    }

    public static Complex add(Complex z1, Complex z2)
    {
        return new Complex(z1.real + z2.real, z1.imaginary + z2.imaginary);
    }

    @Override
    public String toString()
    {
        String re = this.real+"";
        String im = "";
        if(this.imaginary < 0)
            im = this.imaginary+"i";
        else
            im = "+"+this.imaginary+"i";
        return re+im;
    }

}