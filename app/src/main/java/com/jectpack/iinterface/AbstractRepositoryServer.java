package com.jectpack.iinterface;


import javax.inject.Inject;

public abstract class AbstractRepositoryServer {

    public AbstractRepositoryServer(){

    }

    public abstract void request(String url);
}
