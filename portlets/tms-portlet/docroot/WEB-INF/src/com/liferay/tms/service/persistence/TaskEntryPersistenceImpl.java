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

package com.liferay.tms.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.tms.NoSuchTaskEntryException;
import com.liferay.tms.model.TaskEntry;
import com.liferay.tms.model.impl.TaskEntryImpl;
import com.liferay.tms.model.impl.TaskEntryModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="TaskEntryPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class TaskEntryPersistenceImpl extends BasePersistenceImpl
	implements TaskEntryPersistence {
	public TaskEntry create(long taskEntryId) {
		TaskEntry taskEntry = new TaskEntryImpl();

		taskEntry.setNew(true);
		taskEntry.setPrimaryKey(taskEntryId);

		return taskEntry;
	}

	public TaskEntry remove(long taskEntryId)
		throws NoSuchTaskEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskEntry taskEntry = (TaskEntry)session.get(TaskEntryImpl.class,
					new Long(taskEntryId));

			if (taskEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No TaskEntry exists with the primary key " +
						taskEntryId);
				}

				throw new NoSuchTaskEntryException(
					"No TaskEntry exists with the primary key " + taskEntryId);
			}

			return remove(taskEntry);
		}
		catch (NoSuchTaskEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public TaskEntry remove(TaskEntry taskEntry) throws SystemException {
		for (ModelListener listener : listeners) {
			listener.onBeforeRemove(taskEntry);
		}

		taskEntry = removeImpl(taskEntry);

		for (ModelListener listener : listeners) {
			listener.onAfterRemove(taskEntry);
		}

		return taskEntry;
	}

	protected TaskEntry removeImpl(TaskEntry taskEntry)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(TaskEntryImpl.class,
						taskEntry.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(taskEntry);

			session.flush();

			return taskEntry;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);

			FinderCacheUtil.clearCache(TaskEntry.class.getName());
		}
	}

	public TaskEntry update(TaskEntry taskEntry) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(TaskEntry taskEntry) method. Use update(TaskEntry taskEntry, boolean merge) instead.");
		}

		return update(taskEntry, false);
	}

	public TaskEntry update(TaskEntry taskEntry, boolean merge)
		throws SystemException {
		boolean isNew = taskEntry.isNew();

		for (ModelListener listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(taskEntry);
			}
			else {
				listener.onBeforeUpdate(taskEntry);
			}
		}

		taskEntry = updateImpl(taskEntry, merge);

		for (ModelListener listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(taskEntry);
			}
			else {
				listener.onAfterUpdate(taskEntry);
			}
		}

		return taskEntry;
	}

	public TaskEntry updateImpl(com.liferay.tms.model.TaskEntry taskEntry,
		boolean merge) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taskEntry, merge);

			taskEntry.setNew(false);

			return taskEntry;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);

			FinderCacheUtil.clearCache(TaskEntry.class.getName());
		}
	}

	public TaskEntry findByPrimaryKey(long taskEntryId)
		throws NoSuchTaskEntryException, SystemException {
		TaskEntry taskEntry = fetchByPrimaryKey(taskEntryId);

		if (taskEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No TaskEntry exists with the primary key " +
					taskEntryId);
			}

			throw new NoSuchTaskEntryException(
				"No TaskEntry exists with the primary key " + taskEntryId);
		}

		return taskEntry;
	}

	public TaskEntry fetchByPrimaryKey(long taskEntryId)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			return (TaskEntry)session.get(TaskEntryImpl.class,
				new Long(taskEntryId));
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<TaskEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<TaskEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<TaskEntry> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		boolean finderClassNameCacheEnabled = TaskEntryModelImpl.CACHE_ENABLED;
		String finderClassName = TaskEntry.class.getName();
		String finderMethodName = "findAll";
		String[] finderParams = new String[] {
				"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("FROM com.liferay.tms.model.TaskEntry ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				Query q = session.createQuery(query.toString());

				List<TaskEntry> list = null;

				if (obc == null) {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, list);

				return list;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return (List<TaskEntry>)result;
		}
	}

	public void removeAll() throws SystemException {
		for (TaskEntry taskEntry : findAll()) {
			remove(taskEntry);
		}
	}

	public int countAll() throws SystemException {
		boolean finderClassNameCacheEnabled = TaskEntryModelImpl.CACHE_ENABLED;
		String finderClassName = TaskEntry.class.getName();
		String finderMethodName = "countAll";
		String[] finderParams = new String[] {  };
		Object[] finderArgs = new Object[] {  };

		Object result = null;

		if (finderClassNameCacheEnabled) {
			result = FinderCacheUtil.getResult(finderClassName,
					finderMethodName, finderParams, finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM com.liferay.tms.model.TaskEntry");

				Long count = null;

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}

				if (count == null) {
					count = new Long(0);
				}

				FinderCacheUtil.putResult(finderClassNameCacheEnabled,
					finderClassName, finderMethodName, finderParams,
					finderArgs, count);

				return count.intValue();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}
		else {
			return ((Long)result).intValue();
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.tms.model.TaskEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener> listenersList = new ArrayList<ModelListener>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "com.liferay.tms.service.persistence.ProjectEntryPersistence.impl")
	protected com.liferay.tms.service.persistence.ProjectEntryPersistence projectEntryPersistence;
	@BeanReference(name = "com.liferay.tms.service.persistence.ProjectMilestonePersistence.impl")
	protected com.liferay.tms.service.persistence.ProjectMilestonePersistence projectMilestonePersistence;
	@BeanReference(name = "com.liferay.tms.service.persistence.TaskEntryPersistence.impl")
	protected com.liferay.tms.service.persistence.TaskEntryPersistence taskEntryPersistence;
	@BeanReference(name = "com.liferay.tms.service.persistence.TaskViewPersistence.impl")
	protected com.liferay.tms.service.persistence.TaskViewPersistence taskViewPersistence;
	@BeanReference(name = "com.liferay.portlet.tags.service.persistence.TagsAssetPersistence.impl")
	protected com.liferay.portlet.tags.service.persistence.TagsAssetPersistence tagsAssetPersistence;
	@BeanReference(name = "com.liferay.portlet.tags.service.persistence.TagsEntryPersistence.impl")
	protected com.liferay.portlet.tags.service.persistence.TagsEntryPersistence tagsEntryPersistence;
	private static Log _log = LogFactoryUtil.getLog(TaskEntryPersistenceImpl.class);
}