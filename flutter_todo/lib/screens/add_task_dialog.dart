import 'package:flutter/material.dart';

class AddTaskDialog extends StatelessWidget {
  const AddTaskDialog({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SizedBox.expand(child: Column(crossAxisAlignment: CrossAxisAlignment.stretch, children: [
  SizedBox.expand(child: TextField(decoration: InputDecoration(hintText: "Task")))
])),
    );
  }
}