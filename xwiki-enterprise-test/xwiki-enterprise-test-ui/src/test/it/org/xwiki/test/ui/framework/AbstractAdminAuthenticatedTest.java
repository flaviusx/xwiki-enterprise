/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.test.ui.framework;

import org.junit.Before;

/**
 * Helper class to be extended by tests requiring an Admin user logged in.
 *
 * @version $Id$
 * @since 2.3M1
 */
public class AbstractAdminAuthenticatedTest extends AbstractTest
{
    @Before
    public void setUp()
    {
        if (getUtil().getLoggedInUserName() != "Admin") {
            // Log in and direct to a non existent page so that it loads very fast (we load it in plain mode so that
            // we don't even have to display the skin ;)) and we don't incur the time cost of going to the home page
            // for example.
            getDriver().get(getUtil().getURLToLoginAsAdminAndGotoPage(
                getUtil().getURL("NonExistentSpace", "NonExistentPage", "view", "xpage=plain")));
        }
    }
}
