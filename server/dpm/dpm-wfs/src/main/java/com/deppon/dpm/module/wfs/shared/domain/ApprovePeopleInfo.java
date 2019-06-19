package com.deppon.dpm.module.wfs.shared.domain;

public class ApprovePeopleInfo {
//审批人ID
private String participantId;
//审批人姓名
private String participantName;
/**
 * @return the participantId
 */
public String getParticipantId() {
	return participantId;
}
/**
 * @param participantId the participantId to set
 */
public void setParticipantId(String participantId) {
	this.participantId = participantId;
}
/**
 * @return the participantName
 */
public String getParticipantName() {
	return participantName;
}
/**
 * @param participantName the participantName to set
 */
public void setParticipantName(String participantName) {
	this.participantName = participantName;
}
}
