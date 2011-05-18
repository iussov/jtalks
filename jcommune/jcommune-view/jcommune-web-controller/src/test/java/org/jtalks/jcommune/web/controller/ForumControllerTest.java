/**
 * Copyright (C) 2011  jtalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * Also add information on how to contact you by electronic and paper mail.
 * Creation date: Apr 12, 2011 / 8:05:19 PM
 * The jtalks.org Project
 */
package org.jtalks.jcommune.web.controller;

import org.jtalks.jcommune.model.entity.TopicBranch;
import org.jtalks.jcommune.service.TopicBranchService;
import org.jtalks.jcommune.service.TopicService;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;


public class ForumControllerTest {
    private TopicService topicService;
    private TopicBranchService branchService;
    private ForumController forumController;

    @BeforeMethod
    public void init() {
        topicService = mock(TopicService.class);
        branchService = mock(TopicBranchService.class);
        forumController = new ForumController(topicService, branchService);
    }

    @Test
    public void testShowAllTopics() {
        TopicBranch topicBranch = new TopicBranch();
        topicBranch.setId(1l);
        when(branchService.get(1l)).thenReturn(topicBranch);

        ModelAndView mav = forumController.showAllTopics(1l);

        assertViewName(mav, "forum");
        verify(branchService, times(1)).get(1l);
    }

}
