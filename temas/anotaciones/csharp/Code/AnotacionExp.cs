﻿using System.ComponentModel.DataAnnotations;

[AttributeUsage(AttributeTargets.Method)]
public class AnotacionExpAttribute : Attribute{
    public int ExpGanada { get; }

    public AnotacionExpAttribute(int exp){
        ExpGanada = exp;
    }
}