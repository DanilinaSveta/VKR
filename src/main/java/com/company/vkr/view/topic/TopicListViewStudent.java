package com.company.vkr.view.topic;

import com.company.vkr.entity.Topic;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "topicsStudent", layout = MainView.class)
@ViewController(id = "TopicStudent.list")
@ViewDescriptor(path = "topic-list-view-student.xml")
@LookupComponent("topicsDataGrid")
@DialogMode(width = "64em")
public class TopicListViewStudent extends StandardListView<Topic> {
}