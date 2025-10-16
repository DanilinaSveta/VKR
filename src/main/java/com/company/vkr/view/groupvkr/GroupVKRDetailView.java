package com.company.vkr.view.groupvkr;

import com.company.vkr.entity.GroupVKR;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "groupVKRs/:id", layout = MainView.class)
@ViewController(id = "GroupVKR.detail")
@ViewDescriptor(path = "group-vkr-detail-view.xml")
@EditedEntityContainer("groupVKRDc")
public class GroupVKRDetailView extends StandardDetailView<GroupVKR> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(InitEntityEvent<GroupVKR> event){
        String username = currentAuthentication.getUser().getUsername();
        event.getEntity().setStudentName(username);
    }
}