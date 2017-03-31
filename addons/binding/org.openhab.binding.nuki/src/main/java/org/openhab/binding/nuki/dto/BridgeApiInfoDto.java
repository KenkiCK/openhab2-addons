/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nuki.dto;

import java.util.List;

/**
 * The {@link BridgeApiInfoDto} class defines the Data Transfer Object (POJO) for the Nuki Bridge API /info endpoint.
 *
 * @author Markus Katter - Initial contribution
 */
public class BridgeApiInfoDto {

    private int bridgeType;
<<<<<<< HEAD
<<<<<<< HEAD
    private BridgeApiInfoIdDto ids;
    private BridgeApiInfoVersionDto versions;
    private int uptime;
    private String currentTime;
    private boolean serverConnected;
    private List<BridgeApiInfoScanResultDto> scanResults;
=======
    private BridgeApiInfoIdsDto ids;
    private BridgeApiInfoVersionsDto versions;
    private int uptime;
    private String currentTime;
    private boolean serverConnected;
    private List<BridgeApiInfoScanResultsDto> scanResults;
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
    private BridgeApiInfoIdDto ids;
    private BridgeApiInfoVersionDto versions;
    private int uptime;
    private String currentTime;
    private boolean serverConnected;
    private List<BridgeApiInfoScanResultDto> scanResults;
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize

    public int getBridgeType() {
        return bridgeType;
    }

    public void setBridgeType(int bridgeType) {
        this.bridgeType = bridgeType;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public BridgeApiInfoIdDto getIds() {
        return ids;
    }

    public void setIds(BridgeApiInfoIdDto ids) {
        this.ids = ids;
    }

    public BridgeApiInfoVersionDto getVersions() {
        return versions;
    }

    public void setVersions(BridgeApiInfoVersionDto versions) {
=======
    public BridgeApiInfoIdsDto getIds() {
=======
    public BridgeApiInfoIdDto getIds() {
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize
        return ids;
    }

    public void setIds(BridgeApiInfoIdDto ids) {
        this.ids = ids;
    }

    public BridgeApiInfoVersionDto getVersions() {
        return versions;
    }

<<<<<<< HEAD
    public void setVersions(BridgeApiInfoVersionsDto versions) {
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
    public void setVersions(BridgeApiInfoVersionDto versions) {
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize
        this.versions = versions;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isServerConnected() {
        return serverConnected;
    }

    public void setServerConnected(boolean serverConnected) {
        this.serverConnected = serverConnected;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public List<BridgeApiInfoScanResultDto> getScanResults() {
        return scanResults;
    }

    public void setScanResults(List<BridgeApiInfoScanResultDto> scanResults) {
=======
    public List<BridgeApiInfoScanResultsDto> getScanResults() {
        return scanResults;
    }

    public void setScanResults(List<BridgeApiInfoScanResultsDto> scanResults) {
>>>>>>> 0a5308483... Implemented NukiBridgeHandler initialize
=======
    public List<BridgeApiInfoScanResultDto> getScanResults() {
        return scanResults;
    }

    public void setScanResults(List<BridgeApiInfoScanResultDto> scanResults) {
>>>>>>> a3d389951... Implemented NukiSmartLockHandlerHandler initialize
        this.scanResults = scanResults;
    }

}
