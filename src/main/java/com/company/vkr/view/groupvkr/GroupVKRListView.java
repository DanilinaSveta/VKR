package com.company.vkr.view.groupvkr;

import com.company.vkr.entity.GroupVKR;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import io.jmix.core.validation.group.UiCrossFieldChecks;
import io.jmix.flowui.action.SecuredBaseAction;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.component.validation.ValidationErrors;
import io.jmix.flowui.kit.action.Action;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.*;

@Route(value = "groupVKRs", layout = MainView.class)
@ViewController(id = "GroupVKR.list")
@ViewDescriptor(path = "group-vkr-list-view.xml")
@LookupComponent("groupVKRsDataGrid")
@DialogMode(width = "64em")
public class GroupVKRListView extends StandardListView<GroupVKR> {

    @ViewComponent
    private DataContext dataContext;

    @ViewComponent
    private CollectionContainer<GroupVKR> groupVKRsDc;

    @ViewComponent
    private InstanceContainer<GroupVKR> groupVKRDc;

    @ViewComponent
    private InstanceLoader<GroupVKR> groupVKRDl;

    @ViewComponent
    private VerticalLayout listLayout;

    @ViewComponent
    private DataGrid<GroupVKR> groupVKRsDataGrid;

    @ViewComponent
    private FormLayout form;

    @ViewComponent
    private HorizontalLayout detailActions;

    @Subscribe
    public void onInit(final InitEvent event) {
        groupVKRsDataGrid.getActions().forEach(action -> {
            if (action instanceof SecuredBaseAction secured) {
                secured.addEnabledRule(() -> listLayout.isEnabled());
            }
        });
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        updateControls(false);
    }

    @Subscribe("groupVKRsDataGrid.create")
    public void onGroupVKRsDataGridCreate(final ActionPerformedEvent event) {
        dataContext.clear();
        GroupVKR entity = dataContext.create(GroupVKR.class);
        groupVKRDc.setItem(entity);
        updateControls(true);
    }

    @Subscribe("groupVKRsDataGrid.edit")
    public void onGroupVKRsDataGridEdit(final ActionPerformedEvent event) {
        updateControls(true);
    }

    @Subscribe("saveButton")
    public void onSaveButtonClick(final ClickEvent<JmixButton> event) {
        GroupVKR item = groupVKRDc.getItem();
        ValidationErrors validationErrors = validateView(item);
        if (!validationErrors.isEmpty()) {
            ViewValidation viewValidation = getViewValidation();
            viewValidation.showValidationErrors(validationErrors);
            viewValidation.focusProblemComponent(validationErrors);
            return;
        }
        dataContext.save();
        groupVKRsDc.replaceItem(item);
        updateControls(false);
    }

    @Subscribe("cancelButton")
    public void onCancelButtonClick(final ClickEvent<JmixButton> event) {
        dataContext.clear();
        groupVKRDc.setItem(null);
        groupVKRDl.load();
        updateControls(false);
    }

    @Subscribe(id = "groupVKRsDc", target = Target.DATA_CONTAINER)
    public void onGroupVKRsDcItemChange(final InstanceContainer.ItemChangeEvent<GroupVKR> event) {
        GroupVKR entity = event.getItem();
        dataContext.clear();
        if (entity != null) {
            groupVKRDl.setEntityId(entity.getId());
            groupVKRDl.load();
        } else {
            groupVKRDl.setEntityId(null);
            groupVKRDc.setItem(null);
        }
        updateControls(false);
    }

    protected ValidationErrors validateView(GroupVKR entity) {
        ViewValidation viewValidation = getViewValidation();
        ValidationErrors validationErrors = viewValidation.validateUiComponents(form);
        if (!validationErrors.isEmpty()) {
            return validationErrors;
        }
        validationErrors.addAll(viewValidation.validateBeanGroup(UiCrossFieldChecks.class, entity));
        return validationErrors;
    }

    private void updateControls(boolean editing) {
        UiComponentUtils.getComponents(form).forEach(component -> {
            if (component instanceof HasValueAndElement<?, ?> field) {
                field.setReadOnly(!editing);
            }
        });

        detailActions.setVisible(editing);
        listLayout.setEnabled(!editing);
        groupVKRsDataGrid.getActions().forEach(Action::refreshState);
    }

    private ViewValidation getViewValidation() {
        return getApplicationContext().getBean(ViewValidation.class);
    }
}