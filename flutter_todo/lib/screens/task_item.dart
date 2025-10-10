import 'package:flutter/material.dart';

class TaskItem extends StatelessWidget {
  const TaskItem({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(padding: EdgeInsets.only(bottom: 10.0), child: SizedBox.expand(child: Padding(padding: EdgeInsets.all(10.0), child: Column(crossAxisAlignment: CrossAxisAlignment.stretch, children: [
  SizedBox.expand(child: Row(children: [
    Text("", style: TextStyle(color: Color(0xFF393939))),
    Expanded(child: SizedBox.shrink()),
    Checkbox(value: false, onChanged: (v){})
  ])),
  Align(alignment: Alignment.centerRight, child: SizedBox.expand(child: Text("", style: TextStyle(fontSize: 12.0, color: Color(0xFF858484)))))
])))),
    );
  }
}