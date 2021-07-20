package com.jetpack.aidl;

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}