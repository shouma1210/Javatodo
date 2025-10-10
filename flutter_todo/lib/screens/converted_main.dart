import 'package:flutter/material.dart';

class ConvertedMain extends StatelessWidget {
  const ConvertedMain({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SizedBox.expand(child: Stack(children: [
  SizedBox(),
  Padding(padding: EdgeInsets.only(bottom: 50.0), child: Align(alignment: Alignment.bottomRight, child: Padding(padding: EdgeInsets.only(bottom: 50.0), child: SizedBox.expand(child: Expanded(child: ListView.builder(itemCount: 20, itemBuilder: (ctx, i) => const SizedBox(height: 48))))))),
  Align(alignment: Alignment.bottomCenter, child: ElevatedButton(onPressed: (){}, child: Text("add new task")))
])),
    );
  }
}