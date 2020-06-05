# Mars Rover
题目
```text
假想你在火星探索团队中负责软件开发。现在你要给登陆火星的探索小车编写控制程序，根据地球发送的控制指令来控制火星车的行动。

火星车收到的指令分为三类：

1. 初始化信息：
    火星车的降落地点（x, y）和朝向（N, S, E, W）信息；

2. 移动指令：
    火星车可以前进（M）,一次移动一格；

3. 转向指令：
    火星车可以左转90度（L）或右转90度（R）。

由于地球和火星之间的距离很远，指令必须批量发送，火星车执行完整批指令之后，再回报自己所在的位置坐标和朝向。
（0，0）N
MMMM =》 （0，4） N
L => (0,0) W
MLMR => (x,y) ?

但是由于火星地形复杂，所以火星车只能在安全可行区域内活动，当火星车执行移动指令时超出了安全可行区域，火星车将不执行该指令以及后续批量指令，并留在原地。
```
## 增加边界后的测试
- should_just_move_to_max_y_given_command_is_MM_and_facing_is_N_and_max_y_of_bound
- should_just_move_to_min_y_given_command_is_MM_and_facing_is_S_and_min_y_of_bound
- should_just_move_to_max_x_given_command_is_MM_and_facing_is_E_and_max_x_of_bound
- should_just_move_to_min_x_given_command_is_MM_and_facing_is_W_and_min_x_of_bound
- should_ignore_more_move_given_command_is_MMM_and_at_bound
- should_turn_left_successfully_given_command_is_L_and_facing_is_E_and_at_bound
- should_turn_right_successfully_given_command_is_R_and_facing_is_N_and_at_bound
- should_ignore_any_command_given_command_is_ML_and_at_bound
- should_return_correct_location_given_command_is_MMRMMM_facing_is_N_and_max_y_of_bound_is_2_and_max_x_of_bound_is_2
