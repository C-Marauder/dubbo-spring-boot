package com.xqy.www.task.dao

import org.quartz.JobDetail
import org.quartz.JobKey
import org.quartz.Trigger
import org.quartz.TriggerKey

data class TaskInformation(var jobKey:JobKey,var jobDetail:JobDetail,var triggerKey: TriggerKey,var trigger: Trigger, var isPaused:Boolean)