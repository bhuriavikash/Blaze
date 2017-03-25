/**
 * Copyright (C) 2010-2012 Regis Montoya (aka r3gis - www.r3gis.fr)
 * This file is part of CSipSimple.
 *
 *  CSipSimple is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  If you own a pjsip commercial license you can also redistribute it
 *  and/or modify it under the terms of the GNU Lesser General Public License
 *  as an android library.
 *
 *  CSipSimple is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CSipSimple.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ncrsoft.wizards.impl;

import com.ncrsoft.api.SipConfigManager;
import com.ncrsoft.api.SipProfile;
import com.ncrsoft.utils.PreferencesWrapper;

public class SecureCall extends SimpleImplementation {

    @Override
    protected String getDefaultName() {
        return "SecureCall";
    }

    /* (non-Javadoc)
     * @see com.csipsimple.wizards.impl.SimpleImplementation#getDomain()
     */
    @Override
    protected String getDomain() {
        return "sip.securecall.org";
    }
    
    public SipProfile buildAccount(SipProfile account) {
        account = super.buildAccount(account);
        String domain = getDomain();
        account.proxies = new String[] {
            "sips:" + domain
        };
        account.transport = SipProfile.TRANSPORT_TLS;
        account.use_srtp = 2; /*Mandatory*/
        return account;
    }

    @Override
    public void setDefaultParams(PreferencesWrapper prefs) {
        super.setDefaultParams(prefs);
        prefs.setPreferenceBooleanValue(SipConfigManager.ENABLE_TLS, true);
    }

    @Override
    public boolean needRestart() {
        return true;
    }

}
