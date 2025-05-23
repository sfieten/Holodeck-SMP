/*
 * Copyright (C) 2022 The Holodeck B2B Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Affero GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.holodeckb2b.bdxr.smp.server.ui.viewmodels;

import org.holodeckb2b.bdxr.smp.server.ui.UserAccount;
import org.holodeckb2b.bdxr.smp.server.ui.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * UI model for editing a user account.
 *
 * @author Sander Fieten (sander at holodeck-b2b.org)
 */
@Getter
@Setter
public class UserAccountFormData {
	private Long	oid;

	@Email
	@NotBlank(message = "An email address must be provided")
	private String	emailAddress;
	@NotBlank(message = "The user's name must be provided")
	private String	fullName;
	private String	password;
	private boolean isAdmin = false;

	public UserAccountFormData(UserAccount u) {
		if (u != null) {
			oid = u.getOid();
			emailAddress = u.getEmailAddress();
			fullName = u.getFullName();
			isAdmin = u.getRoles().contains(UserRole.ADMIN);
		}
	}
}
