import java.util.*;

class Solution { 
    public String[] solution(String[][] plansArr) { 
        Task[] tasks = new Task[plansArr.length];
        for (int i = 0; i < plansArr.length; i++) {
            tasks[i] = new Task(plansArr[i]);
        }
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.startTime)); 

        Stack<Task> pausedTasks = new Stack<>();
        List<String> completedTasks = new ArrayList<>();
        for (int i = 0; i < tasks.length - 1; i++) {
            Task currentTask = tasks[i];
            Task nextTask = tasks[i + 1];

            if (currentTask.getEndTime() > nextTask.startTime) {
                currentTask.remainingTime = currentTask.getEndTime() - nextTask.startTime;
                pausedTasks.push(currentTask);
                continue;
            }
            completedTasks.add(currentTask.name);

            int availableTime = nextTask.startTime - currentTask.getEndTime();
            while (availableTime > 0 && !pausedTasks.isEmpty()) {
                Task pausedTask = pausedTasks.peek();
                int timeDifference = pausedTask.remainingTime - availableTime;
                pausedTask.remainingTime = timeDifference;
                availableTime = -timeDifference;
                if (timeDifference > 0) break;
                completedTasks.add(pausedTasks.pop().name);
            }
        }

        completedTasks.add(tasks[tasks.length - 1].name);
        while (!pausedTasks.isEmpty()) completedTasks.add(pausedTasks.pop().name);

        return completedTasks.toArray(new String[0]);
    }
}

class Task {
    String name;
    int startTime;
    int remainingTime;

    public Task(String name, String startTime, String duration) {
        this.name = name;
        String[] timeParts = startTime.split(":");
        this.startTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        this.remainingTime = Integer.parseInt(duration);
    }

    public Task(String[] taskDetails) {
        this(taskDetails[0], taskDetails[1], taskDetails[2]);
    }

    public int getEndTime() {
        return startTime + remainingTime;
    }
}
