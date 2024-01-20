package cn.tuids.check.module;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

/**
 * @author tuids
 * @date 2024/1/21 0:10
 */
@GroupSequence({Default.class, GroupB.class, GroupA.class})
public interface GroupI {
}
