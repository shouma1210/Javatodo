import 'package:flutter/material.dart';
// ★ 生成した画面を import
import 'screens/converted_main.dart';
import 'screens/add_task_dialog.dart';
import 'screens/task_item.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Todo',
      theme: ThemeData(primarySwatch: Colors.blue),

      // ★ add-to-app 用ルート
      routes: {
        '/converted_main': (_) => const ConvertedMain(),
        '/add_task_dialog': (_) => const AddTaskDialog(),
        '/task_item_demo': (_) => const TaskItem(),
      },

      // ★ 単体起動時に表示する画面
      home: const ConvertedMain(),
    );
  }
}
