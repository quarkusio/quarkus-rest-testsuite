/*
 * Copyright (c) 2012, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.ts.tests.jaxrs.spec.resource.requestmatching;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resource")
public class MainResource {
    public static final String ID = "resource";

    @GET
    public String main() {
        return ID;
    }

    @Path(MainSubResource.ID)
    @GET
    public String sub() {
        return MainResource.class.getSimpleName();
    }

    @GET
    @Path("locator/locator/locator")
    public String locator() {
        return MainResourceLocator.class.getSimpleName();
    }

    @GET
    @Path("{id}")
    public String id() {
        return ID;
    }

    @POST
    @Path("consumes")
    @Consumes(MediaType.TEXT_PLAIN)
    public String consumes() {
        return getClass().getSimpleName();
    }

    @Path("consumeslocator")
    public MainResourceLocator consumeslocator() {
        return new MainResourceLocator();
    }

    @POST
    @Path("produces")
    @Produces(MediaType.TEXT_PLAIN)
    public String produces() {
        return getClass().getSimpleName();
    }

    @Path("produceslocator")
    public MainResourceLocator produceslocator() {
        return new MainResourceLocator();
    }

    @Path("l2locator")
    public Object l2locator() {
        return new MainResourceLocator();
    }

}
