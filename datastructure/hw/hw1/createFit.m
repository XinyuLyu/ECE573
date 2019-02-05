function [fitresult, gof] = createFit(x, y)
%CREATEFIT(X,Y)
%  Create a fit.
%
%  Data for '3-sum(O(N^3))' fit:
%      X Input : x
%      Y Output: y
%  Output:
%      fitresult : a fit object representing the fit.
%      gof : structure with goodness-of fit info.
%
%  另请参阅 FIT, CFIT, SFIT.

%  由 MATLAB 于 05-Feb-2018 11:23:58 自动生成


%% Fit: '3-sum(O(N^3))'.
[xData, yData] = prepareCurveData( x, y );

% Set up fittype and options.
ft = fittype( 'power1' );
opts = fitoptions( 'Method', 'NonlinearLeastSquares' );
opts.Display = 'Off';
opts.StartPoint = [0.000594910849856069 2.18695595608976];

% Fit model to data.
[fitresult, gof] = fit( xData, yData, ft, opts );

% Plot fit with data.
figure( 'Name', '3-sum(O(N^3))' );
plot( fitresult, xData, yData );
% Label axes
xlabel x
ylabel y
grid on


