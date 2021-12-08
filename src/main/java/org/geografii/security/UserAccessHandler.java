package org.geografii.security;

public interface UserAccessHandler {
    /**
     * Determines whether the logged in user can see data for a specific role
     * @param id The id of the role
     * @return True if it has access, otherwise false
     */
    boolean canSearchRole(int id) throws Exception;
}
