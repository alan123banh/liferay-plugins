/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.tms.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.liferay.tms.model.TaskView;
import com.liferay.tms.service.ProjectEntryLocalService;
import com.liferay.tms.service.ProjectMilestoneLocalService;
import com.liferay.tms.service.TaskEntryLocalService;
import com.liferay.tms.service.TaskViewLocalService;
import com.liferay.tms.service.persistence.ProjectEntryPersistence;
import com.liferay.tms.service.persistence.ProjectMilestonePersistence;
import com.liferay.tms.service.persistence.TaskEntryPersistence;
import com.liferay.tms.service.persistence.TaskViewPersistence;

import java.util.List;

/**
 * <a href="TaskViewLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class TaskViewLocalServiceBaseImpl
	implements TaskViewLocalService {
	public TaskView addTaskView(TaskView taskView) throws SystemException {
		taskView.setNew(true);

		return taskViewPersistence.update(taskView, false);
	}

	public TaskView createTaskView(long taskViewId) {
		return taskViewPersistence.create(taskViewId);
	}

	public void deleteTaskView(long taskViewId)
		throws PortalException, SystemException {
		taskViewPersistence.remove(taskViewId);
	}

	public void deleteTaskView(TaskView taskView) throws SystemException {
		taskViewPersistence.remove(taskView);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return taskViewPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return taskViewPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	public TaskView getTaskView(long taskViewId)
		throws PortalException, SystemException {
		return taskViewPersistence.findByPrimaryKey(taskViewId);
	}

	public List<TaskView> getTaskViews(int start, int end)
		throws SystemException {
		return taskViewPersistence.findAll(start, end);
	}

	public int getTaskViewsCount() throws SystemException {
		return taskViewPersistence.countAll();
	}

	public TaskView updateTaskView(TaskView taskView) throws SystemException {
		taskView.setNew(false);

		return taskViewPersistence.update(taskView, true);
	}

	public ProjectEntryLocalService getProjectEntryLocalService() {
		return projectEntryLocalService;
	}

	public void setProjectEntryLocalService(
		ProjectEntryLocalService projectEntryLocalService) {
		this.projectEntryLocalService = projectEntryLocalService;
	}

	public ProjectEntryPersistence getProjectEntryPersistence() {
		return projectEntryPersistence;
	}

	public void setProjectEntryPersistence(
		ProjectEntryPersistence projectEntryPersistence) {
		this.projectEntryPersistence = projectEntryPersistence;
	}

	public ProjectMilestoneLocalService getProjectMilestoneLocalService() {
		return projectMilestoneLocalService;
	}

	public void setProjectMilestoneLocalService(
		ProjectMilestoneLocalService projectMilestoneLocalService) {
		this.projectMilestoneLocalService = projectMilestoneLocalService;
	}

	public ProjectMilestonePersistence getProjectMilestonePersistence() {
		return projectMilestonePersistence;
	}

	public void setProjectMilestonePersistence(
		ProjectMilestonePersistence projectMilestonePersistence) {
		this.projectMilestonePersistence = projectMilestonePersistence;
	}

	public TaskEntryLocalService getTaskEntryLocalService() {
		return taskEntryLocalService;
	}

	public void setTaskEntryLocalService(
		TaskEntryLocalService taskEntryLocalService) {
		this.taskEntryLocalService = taskEntryLocalService;
	}

	public TaskEntryPersistence getTaskEntryPersistence() {
		return taskEntryPersistence;
	}

	public void setTaskEntryPersistence(
		TaskEntryPersistence taskEntryPersistence) {
		this.taskEntryPersistence = taskEntryPersistence;
	}

	public TaskViewLocalService getTaskViewLocalService() {
		return taskViewLocalService;
	}

	public void setTaskViewLocalService(
		TaskViewLocalService taskViewLocalService) {
		this.taskViewLocalService = taskViewLocalService;
	}

	public TaskViewPersistence getTaskViewPersistence() {
		return taskViewPersistence;
	}

	public void setTaskViewPersistence(TaskViewPersistence taskViewPersistence) {
		this.taskViewPersistence = taskViewPersistence;
	}

	@BeanReference(name = "com.liferay.tms.service.ProjectEntryLocalService.impl")
	protected ProjectEntryLocalService projectEntryLocalService;
	@BeanReference(name = "com.liferay.tms.service.persistence.ProjectEntryPersistence.impl")
	protected ProjectEntryPersistence projectEntryPersistence;
	@BeanReference(name = "com.liferay.tms.service.ProjectMilestoneLocalService.impl")
	protected ProjectMilestoneLocalService projectMilestoneLocalService;
	@BeanReference(name = "com.liferay.tms.service.persistence.ProjectMilestonePersistence.impl")
	protected ProjectMilestonePersistence projectMilestonePersistence;
	@BeanReference(name = "com.liferay.tms.service.TaskEntryLocalService.impl")
	protected TaskEntryLocalService taskEntryLocalService;
	@BeanReference(name = "com.liferay.tms.service.persistence.TaskEntryPersistence.impl")
	protected TaskEntryPersistence taskEntryPersistence;
	@BeanReference(name = "com.liferay.tms.service.TaskViewLocalService.impl")
	protected TaskViewLocalService taskViewLocalService;
	@BeanReference(name = "com.liferay.tms.service.persistence.TaskViewPersistence.impl")
	protected TaskViewPersistence taskViewPersistence;
}