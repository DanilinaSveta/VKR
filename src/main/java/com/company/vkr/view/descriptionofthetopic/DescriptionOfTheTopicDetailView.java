package com.company.vkr.view.descriptionofthetopic;

import com.company.vkr.entity.DescriptionOfTheTopic;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "descriptionOfTheTopics/:id", layout = MainView.class)
@ViewController(id = "DescriptionOfTheTopic.detail")
@ViewDescriptor(path = "description-of-the-topic-detail-view.xml")
@EditedEntityContainer("descriptionOfTheTopicDc")
public class DescriptionOfTheTopicDetailView extends StandardDetailView<DescriptionOfTheTopic> {
}