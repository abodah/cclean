package org.abodah.petit.cclean.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();

}
