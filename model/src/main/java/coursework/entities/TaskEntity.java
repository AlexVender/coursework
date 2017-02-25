package coursework.entities;

import coursework.interfaces.EntityItem;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "tasks", schema = "public", catalog = "postgres")
public class TaskEntity implements EntityItem {
    private Integer taskId;
    private String name;
    private String description;
    private Integer priority;
    private Integer status;
    private Date startDate;
    private Date dueDate;
    private Integer assigneeId;
    private Integer projectId;
    
    public TaskEntity() {}
    
    public TaskEntity(String name, String description, Integer priority, Integer status,
                      Date startDate, Date dueDate, Integer assigneeId, Integer projectId) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.assigneeId = assigneeId;
        this.projectId = projectId;
    }
    
    @Id
    @Column(name = "task_id", nullable = false)
    public Integer getId() {
        return taskId;
    }
    
    public void setId(Integer taskId) {
        this.taskId = taskId;
    }
    
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Basic
    @Column(name = "description", length = -1)
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Basic
    @Column(name = "priority", nullable = false)
    public Integer getPriority() {
        return priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Basic
    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    @Basic
    @Column(name = "assignee_id", nullable = false)
    public Integer getAssigneeId() {
        return assigneeId;
    }
    
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }
    
    @Basic
    @Column(name = "project_id", nullable = false)
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(taskId, that.taskId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(status, that.status) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(assigneeId, that.assigneeId) &&
                Objects.equals(projectId, that.projectId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(taskId, name, description, priority, status, startDate, dueDate, assigneeId, projectId);
    }
}
