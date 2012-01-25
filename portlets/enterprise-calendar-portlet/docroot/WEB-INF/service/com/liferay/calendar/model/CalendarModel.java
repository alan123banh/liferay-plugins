/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.calendar.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Calendar service. Represents a row in the &quot;Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.calendar.model.impl.CalendarModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.calendar.model.impl.CalendarImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see Calendar
 * @see com.liferay.calendar.model.impl.CalendarImpl
 * @see com.liferay.calendar.model.impl.CalendarModelImpl
 * @generated
 */
public interface CalendarModel extends BaseModel<Calendar>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a calendar model instance should use the {@link Calendar} interface instead.
	 */

	/**
	 * Returns the primary key of this calendar.
	 *
	 * @return the primary key of this calendar
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this calendar.
	 *
	 * @param primaryKey the primary key of this calendar
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this calendar.
	 *
	 * @return the uuid of this calendar
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this calendar.
	 *
	 * @param uuid the uuid of this calendar
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the calendar ID of this calendar.
	 *
	 * @return the calendar ID of this calendar
	 */
	public long getCalendarId();

	/**
	 * Sets the calendar ID of this calendar.
	 *
	 * @param calendarId the calendar ID of this calendar
	 */
	public void setCalendarId(long calendarId);

	/**
	 * Returns the group ID of this calendar.
	 *
	 * @return the group ID of this calendar
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this calendar.
	 *
	 * @param groupId the group ID of this calendar
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this calendar.
	 *
	 * @return the company ID of this calendar
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this calendar.
	 *
	 * @param companyId the company ID of this calendar
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this calendar.
	 *
	 * @return the user ID of this calendar
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this calendar.
	 *
	 * @param userId the user ID of this calendar
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this calendar.
	 *
	 * @return the user uuid of this calendar
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this calendar.
	 *
	 * @param userUuid the user uuid of this calendar
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this calendar.
	 *
	 * @return the user name of this calendar
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this calendar.
	 *
	 * @param userName the user name of this calendar
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this calendar.
	 *
	 * @return the create date of this calendar
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this calendar.
	 *
	 * @param createDate the create date of this calendar
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this calendar.
	 *
	 * @return the modified date of this calendar
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this calendar.
	 *
	 * @param modifiedDate the modified date of this calendar
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the resource block ID of this calendar.
	 *
	 * @return the resource block ID of this calendar
	 */
	public long getResourceBlockId();

	/**
	 * Sets the resource block ID of this calendar.
	 *
	 * @param resourceBlockId the resource block ID of this calendar
	 */
	public void setResourceBlockId(long resourceBlockId);

	/**
	 * Returns the calendar resource ID of this calendar.
	 *
	 * @return the calendar resource ID of this calendar
	 */
	public long getCalendarResourceId();

	/**
	 * Sets the calendar resource ID of this calendar.
	 *
	 * @param calendarResourceId the calendar resource ID of this calendar
	 */
	public void setCalendarResourceId(long calendarResourceId);

	/**
	 * Returns the name of this calendar.
	 *
	 * @return the name of this calendar
	 */
	public String getName();

	/**
	 * Returns the localized name of this calendar in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this calendar
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this calendar in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this calendar. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this calendar in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this calendar
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this calendar in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this calendar
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this calendar.
	 *
	 * @return the locales and localized names of this calendar
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this calendar.
	 *
	 * @param name the name of this calendar
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this calendar in the language.
	 *
	 * @param name the localized name of this calendar
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this calendar in the language, and sets the default locale.
	 *
	 * @param name the localized name of this calendar
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this calendar from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this calendar
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this calendar from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this calendar
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this calendar.
	 *
	 * @return the description of this calendar
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this calendar in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this calendar
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this calendar in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this calendar. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this calendar in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this calendar
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this calendar in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this calendar
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this calendar.
	 *
	 * @return the locales and localized descriptions of this calendar
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this calendar.
	 *
	 * @param description the description of this calendar
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this calendar in the language.
	 *
	 * @param description the localized description of this calendar
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this calendar in the language, and sets the default locale.
	 *
	 * @param description the localized description of this calendar
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this calendar from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this calendar
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this calendar from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this calendar
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the color of this calendar.
	 *
	 * @return the color of this calendar
	 */
	public int getColor();

	/**
	 * Sets the color of this calendar.
	 *
	 * @param color the color of this calendar
	 */
	public void setColor(int color);

	/**
	 * Returns the default calendar of this calendar.
	 *
	 * @return the default calendar of this calendar
	 */
	public boolean getDefaultCalendar();

	/**
	 * Returns <code>true</code> if this calendar is default calendar.
	 *
	 * @return <code>true</code> if this calendar is default calendar; <code>false</code> otherwise
	 */
	public boolean isDefaultCalendar();

	/**
	 * Sets whether this calendar is default calendar.
	 *
	 * @param defaultCalendar the default calendar of this calendar
	 */
	public void setDefaultCalendar(boolean defaultCalendar);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Calendar calendar);

	public int hashCode();

	public CacheModel<Calendar> toCacheModel();

	public Calendar toEscapedModel();

	public String toString();

	public String toXmlString();
}