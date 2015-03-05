// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `Callback_Forum_getInfo.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package TP1;

public abstract class Callback_Forum_getInfo extends Ice.TwowayCallback
{
    public abstract void response(String theme, String moderator, long size);

    public final void __completed(Ice.AsyncResult __result)
    {
        ForumPrx __proxy = (ForumPrx)__result.getProxy();
        Ice.StringHolder theme = new Ice.StringHolder();
        Ice.StringHolder moderator = new Ice.StringHolder();
        Ice.LongHolder size = new Ice.LongHolder();
        try
        {
            __proxy.end_getInfo(theme, moderator, size, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(theme.value, moderator.value, size.value);
    }
}
