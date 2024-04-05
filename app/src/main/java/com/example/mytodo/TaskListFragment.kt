package com.example.mytodo
import MyTaskRecyclerViewAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytodo.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment(), ToDoListListener {
    // connect the fragment_task_list.xml with TaskListFragment class
    private lateinit var binding: FragmentTaskListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
// Set the adapter and layout manager for the RecyclerView
// "with" is a Kotlin extension function that allows you to call
// the methods of an object without explicitly calling the object itself
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyTaskRecyclerViewAdapter(
                Tasks.list,
                this@TaskListFragment
            ) // adapter is responsible for displaying the data
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// Set the action for the FAB
        binding.addButton.setOnClickListener {
// Navigate to the AddTaskFragment with action id
            findNavController().navigate(R.id.action_taskListFragment_to_addTaskFragment)
        }
    }

    override fun onTaskClick(taskPosition: Int) {
// create an action to navigate to the DisplayTaskFragment
//with the selected task at taskPosition

        val actionTaskListFragmentToDisplayTaskFragment =
            TaskListFragmentDirections.actionTaskListFragmentToDisplayTaskFragment(
                Tasks.list[taskPosition])
// use the navigate method to perform the navigation action created above
// we do not use the id of the action in this case
        findNavController().navigate(actionTaskListFragmentToDisplayTaskFragment)
    }

    override fun onTaskLongClick(taskPosition: Int) {
        TODO("Not yet implemented")
    }
}