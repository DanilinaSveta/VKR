package com.company.vkr.view.teacher;

import com.company.vkr.entity.GroupVKR;
import com.company.vkr.entity.Teacher;
import com.company.vkr.view.main.MainView;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.checkboxgroup.JmixCheckboxGroup;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.time.LocalDate;

@Route(value = "teachers/:id", layout = MainView.class)
@ViewController(id = "Teacher.detail")
@ViewDescriptor(path = "teacher-detail-view.xml")
@EditedEntityContainer("teacherDc")
public class TeacherDetailView extends StandardDetailView<Teacher> {

}