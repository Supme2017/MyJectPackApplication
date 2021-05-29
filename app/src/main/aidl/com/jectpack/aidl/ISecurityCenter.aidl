package com.jectpack.aidl;

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}