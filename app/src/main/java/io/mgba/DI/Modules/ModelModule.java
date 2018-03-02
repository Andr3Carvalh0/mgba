package io.mgba.DI.Modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.mgba.Model.IO.FilesManager;
import io.mgba.Model.IO.LocalDB;
import io.mgba.Model.Interfaces.IDatabase;
import io.mgba.Model.Interfaces.IFilesManager;
import io.mgba.Model.Interfaces.ILibrary;
import io.mgba.Model.Library;
import io.mgba.mgba;

@Module
public class ModelModule {
    private mgba application;
    private String path;

    public ModelModule(mgba application, String path) {
        this.application = application;
        this.path = path;
    }

    @Provides
    @Singleton
    public ILibrary provideLibrary(){
        return new Library(application);
    }

    @Provides
    @Singleton
    public IDatabase provideDatabase(){
        return new LocalDB(application);
    }

    @Provides
    @Singleton
    public IFilesManager provideFileManager(){
        return new FilesManager(path);
    }




}