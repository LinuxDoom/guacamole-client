/*
 * Copyright (C) 2014 Glyptodon LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.glyptodon.guacamole.net.basic.rest.connectiongroup;

import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glyptodon.guacamole.net.auth.ConnectionGroup;
import org.glyptodon.guacamole.net.auth.ConnectionGroup.Type;
import org.glyptodon.guacamole.net.basic.rest.connection.APIConnection;

/**
 * A simple connection group to expose through the REST endpoints.
 * 
 * @author James Muehlner
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class APIConnectionGroup {

    /**
     * The identifier of the root connection group.
     */
    public static final String ROOT_IDENTIFIER = "ROOT";
 
    /**
     * The name of this connection group.
     */
    private String name;
    
    /**
     * The identifier of this connection group.
     */
    private String identifier;
    
    /**
     * The identifier of the parent connection group for this connection group.
     */
    private String parentIdentifier;
    
    /**
     * The type of this connection group.
     */
    private Type type;

    /**
     * The count of currently active connections using this connection group.
     */
    private int activeConnections;

    /**
     * All child connection groups. If children are not being queried, this may
     * be omitted.
     */
    private Collection<APIConnectionGroup> childConnectionGroups;

    /**
     * All child connections. If children are not being queried, this may be
     * omitted.
     */
    private Collection<APIConnection> childConnections;
    
    /**
     * Map of all associated attributes by attribute identifier.
     */
    private Map<String, String> attributes;

    /**
     * Create an empty APIConnectionGroup.
     */
    public APIConnectionGroup() {}
    
    /**
     * Create a new APIConnectionGroup from the given ConnectionGroup record.
     * 
     * @param connectionGroup The ConnectionGroup record to initialize this 
     *                        APIConnectionGroup from.
     */
    public APIConnectionGroup(ConnectionGroup connectionGroup) {

        // Set connection group information
        this.identifier = connectionGroup.getIdentifier();
        this.parentIdentifier = connectionGroup.getParentIdentifier();
        this.name = connectionGroup.getName();
        this.type = connectionGroup.getType();
        this.activeConnections = connectionGroup.getActiveConnections();

        // Associate any attributes
        this.attributes = connectionGroup.getAttributes();

    }

    /**
     * Returns the name of this connection group.
     * @return The name of this connection group.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this connection group.
     * @param name The name of this connection group.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the identifier of this connection group.
     * @return The identifier of this connection group.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Set the identifier of this connection group.
     * @param identifier The identifier of this connection group.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    /**
     * Returns the unique identifier for this connection group.
     * @return The unique identifier for this connection group.
     */
    public String getParentIdentifier() {
        return parentIdentifier;
    }
    /**
     * Sets the parent connection group identifier for this connection group.
     * @param parentIdentifier The parent connection group identifier 
     *                         for this connection group.
     */
    public void setParentIdentifier(String parentIdentifier) {
        this.parentIdentifier = parentIdentifier;
    }

    /**
     * Returns the type of this connection group.
     * @return The type of this connection group.
     */
    public Type getType() {
        return type;
    }

    /**
     * Set the type of this connection group.
     * @param type The Type of this connection group.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Returns a collection of all child connection groups, or null if children
     * have not been queried.
     *
     * @return
     *     A collection of all child connection groups, or null if children
     *     have not been queried.
     */
    public Collection<APIConnectionGroup> getChildConnectionGroups() {
        return childConnectionGroups;
    }

    /**
     * Sets the collection of all child connection groups to the given
     * collection, which may be null if children have not been queried.
     *
     * @param childConnectionGroups
     *     The collection containing all child connection groups of this
     *     connection group, or null if children have not been queried.
     */
    public void setChildConnectionGroups(Collection<APIConnectionGroup> childConnectionGroups) {
        this.childConnectionGroups = childConnectionGroups;
    }

    /**
     * Returns a collection of all child connections, or null if children have
     * not been queried.
     *
     * @return
     *     A collection of all child connections, or null if children have not
     *     been queried.
     */
    public Collection<APIConnection> getChildConnections() {
        return childConnections;
    }

    /**
     * Sets the collection of all child connections to the given collection,
     * which may be null if children have not been queried.
     *
     * @param childConnections
     *     The collection containing all child connections of this connection
     *     group, or null if children have not been queried.
     */
    public void setChildConnections(Collection<APIConnection> childConnections) {
        this.childConnections = childConnections;
    }

    /**
     * Returns the number of currently active connections using this
     * connection group.
     *
     * @return
     *     The number of currently active usages of this connection group.
     */
    public int getActiveConnections() {
        return activeConnections;
    }

    /**
     * Set the number of currently active connections using this connection
     * group.
     *
     * @param activeConnections
     *     The number of currently active usages of this connection group.
     */
    public void setActiveUsers(int activeConnections) {
        this.activeConnections = activeConnections;
    }

    /**
     * Returns a map of all attributes associated with this connection group.
     * Each entry key is the attribute identifier, while each value is the
     * attribute value itself.
     *
     * @return
     *     The attribute map for this connection group.
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Sets the map of all attributes associated with this connection group.
     * Each entry key is the attribute identifier, while each value is the
     * attribute value itself.
     *
     * @param attributes
     *     The attribute map for this connection group.
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

}
