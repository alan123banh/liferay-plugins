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

package com.liferay.tms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="TaskViewLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class TaskViewLocalServiceUtil {
	public static com.liferay.tms.model.TaskView addTaskView(
		com.liferay.tms.model.TaskView taskView)
		throws com.liferay.portal.SystemException {
		return getService().addTaskView(taskView);
	}

	public static com.liferay.tms.model.TaskView createTaskView(long taskViewId) {
		return getService().createTaskView(taskViewId);
	}

	public static void deleteTaskView(long taskViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteTaskView(taskViewId);
	}

	public static void deleteTaskView(com.liferay.tms.model.TaskView taskView)
		throws com.liferay.portal.SystemException {
		getService().deleteTaskView(taskView);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static com.liferay.tms.model.TaskView getTaskView(long taskViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getTaskView(taskViewId);
	}

	public static java.util.List<com.liferay.tms.model.TaskView> getTaskViews(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getTaskViews(start, end);
	}

	public static int getTaskViewsCount()
		throws com.liferay.portal.SystemException {
		return getService().getTaskViewsCount();
	}

	public static com.liferay.tms.model.TaskView updateTaskView(
		com.liferay.tms.model.TaskView taskView)
		throws com.liferay.portal.SystemException {
		return getService().updateTaskView(taskView);
	}

	public static TaskViewLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate("tms-portlet",
					TaskViewLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate("tms-portlet",
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new TaskViewLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(TaskViewLocalService service) {
		_service = service;
	}

	private static TaskViewLocalService _service;
}