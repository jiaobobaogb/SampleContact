package com.samplecontact;

import com.britesnow.snow.util.PackageScanner;
import com.britesnow.snow.web.binding.EntityClasses;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.samplecontact.entity.BaseEntity;

public class AppConfig extends AbstractModule{

	@Override
	protected void configure() {
		System.out.println("start up");
	}
	
    @Provides
    @Singleton
    @EntityClasses
    public Class[] provideEntityClasses() {
        try {
            return new PackageScanner(BaseEntity.class.getPackage().getName()).findAnnotatedClasses(javax.persistence.Entity.class);
        } catch (Throwable e) {
            throw new RuntimeException("Cannot get all the enity class: " + e.getMessage());
        }

    }
}
