# Features:
1. Dagger2 (not dagger-android)
2. Single activity
3. FragmentFactory
4. Multi-feature package structure
5. Navigation components 
    - Separate nav graph for each feature

# Info
Each feature has it's own Subcomponent with it's own:
1. ViewModelFactory
2. FragmentFactory
3. NavHostFragment 
    - This is needed since each feature has it's own navigation graph
    
# Next steps:
Build a dynamic multi-feature sample.
