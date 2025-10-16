package com.company.vkr.view.topic;

import com.company.vkr.entity.Topic;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "topics", layout = MainView.class)
@ViewController(id = "Topic.list")
@ViewDescriptor(path = "topic-list-view.xml")
@LookupComponent("topicsDataGrid")
@DialogMode(width = "64em")
public class TopicListView extends StandardListView<Topic> {
}