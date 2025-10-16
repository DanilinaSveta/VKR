package com.company.vkr.view.groupvkr;

import com.company.vkr.entity.GroupVKR;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "groupVKRs", layout = MainView.class)
@ViewController(id = "GroupVKR.list")
@ViewDescriptor(path = "group-vkr-list-view.xml")
@LookupComponent("groupVKRsDataGrid")
@DialogMode(width = "64em")
public class GroupVKRListView extends StandardListView<GroupVKR> {
}