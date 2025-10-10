import 'package:flutter/material.dart';
// ★ 生成した画面をimport
import 'screens/converted_main.dart';
import 'screens/add_task_dialog.dart';
import 'screens/task_item.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(primarySwatch: Colors.blue),

      // ★ ここを追加：add-to-app で使うルートを登録
      routes: {
        '/converted_main': (_) => const ConvertedMain(),
        '/add_task_dialog': (_) => const AddTaskDialog(),
        '/task_item_demo': (_) => const TaskItem(),
      },

      // 単体起動時は今まで通りカウンター画面を home に
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
      // ※ Java から initialRoute を指定して起動した場合は home は無視されます
    );
  }
}
