package com.jetpack.hilt;

import com.jetpack.hilt.annotation.LocalServer;
import com.jetpack.hilt.annotation.RemoteServer;
import com.jetpack.iinterface.AbstractRepositoryServer;
import com.jetpack.iinterface.IRepositoryServer;
import com.jetpack.impl.LocalIRepositoryServer;
import com.jetpack.impl.RemoteRepositoryServer;
import com.jetpack.impl.RemoteRepositoryServerImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public abstract class ServerHiltModule {



    @ActivityScoped
    @LocalServer
    @Binds
    public abstract IRepositoryServer bindLocalIRepositoryServer(LocalIRepositoryServer server);

    @ActivityScoped
    @RemoteServer
    @Binds
    public abstract IRepositoryServer bindRemoteRepositoryServer(RemoteRepositoryServer server);

    @ActivityScoped
    @Binds
    public abstract AbstractRepositoryServer bindAbstractRepositoryServer(RemoteRepositoryServerImpl server);

}
